#!/bin/sh



# Get input from user
read -p "--->Enter module name (all lowercase): " MODULE_NAME


# Set package name
PACKAGE_NAME="com.example.$MODULE_NAME"
MODULE_PATH="feature/$MODULE_NAME"






# Create the module directory
mkdir $MODULE_PATH

# Create the necessary subdirectories
mkdir $MODULE_PATH/libs
mkdir $MODULE_PATH/src
mkdir $MODULE_PATH/src/main
mkdir -p $MODULE_PATH/src/main/java
mkdir -p $MODULE_PATH/src/main/res
mkdir $MODULE_PATH/src/main/res/layout
mkdir $MODULE_PATH/src/main/java/$PACKAGE_NAME
mkdir $MODULE_PATH/src/main/java/$PACKAGE_NAME/presentation
mkdir $MODULE_PATH/src/main/java/$PACKAGE_NAME/repository
mkdir $MODULE_PATH/src/main/java/$PACKAGE_NAME/presentation/ui
mkdir $MODULE_PATH/src/main/java/$PACKAGE_NAME/presentation/ui/activity
mkdir $MODULE_PATH/src/main/java/$PACKAGE_NAME/presentation/ui/fragments
mkdir $MODULE_PATH/src/main/java/$PACKAGE_NAME/presentation/viewModels
mkdir $MODULE_PATH/src/main/java/$PACKAGE_NAME/domain
mkdir $MODULE_PATH/src/main/java/$PACKAGE_NAME/di



MODULE_INTERFACE_PATH="feature/"$MODULE_NAME"Interface"
PACKAGE_NAME_INTERFACE="com.example.$MODULE_MODULE_INTERFACE_PATH"

mkdir $MODULE_INTERFACE_PATH
mkdir $MODULE_INTERFACE_PATH/src
mkdir $MODULE_INTERFACE_PATH/src/main
mkdir -p $MODULE_INTERFACE_PATH/src/main/java
mkdir -p $MODULE_INTERFACE_PATH/src/main/java/"com.example."$MODULE_NAME"Interface"


INTERFACE_MODULE_SET=$MODULE_NAME"Interface"




# Create the build.gradle file
cat <<EOF > $MODULE_PATH/build.gradle
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.feature.$MODULE_NAME"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(":common"))
    implementation(Libs.androidxCore)
    implementation(Libs.androidxAppCompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)

    testImplementation(Libs.junit)
    androidTestImplementation(Libs.testExtJunit)
    androidTestImplementation(Libs.espressoCore)
    testImplementation(Libs.coroutinesTest)

    implementation(Libs.daggerHiltAndroid)
    kapt(Libs.daggerHiltCompiler)

    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)
    implementation(Libs.navigationDynamicFeaturesFragment)
    androidTestImplementation(Libs.navigationTesting)

    implementation(Libs.kotlinxSerializationJson)

    implementation(Libs.retrofit)
    implementation(Libs.gson)
    implementation(Libs.retrofitConverterGson)
    implementation(Libs.okhttp)
    implementation(Libs.retrofitConverterScalars)
    implementation(Libs.loggingInterceptor)

    implementation(Libs.coil)
}

kapt {
    correctErrorTypes = true
}

EOF




# Create the build.gradle file
cat <<EOF > $MODULE_INTERFACE_PATH/build.gradle
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.example.feature.$MODULE_INTERFACEO"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}

dependencies {
    implementation(project(":common"))
    implementation(Libs.androidxCore)
    implementation(Libs.androidxAppCompat)
    implementation(Libs.material)
    implementation(Libs.constraintLayout)

    testImplementation(Libs.junit)
    androidTestImplementation(Libs.testExtJunit)
    androidTestImplementation(Libs.espressoCore)
    testImplementation(Libs.coroutinesTest)

    implementation(Libs.daggerHiltAndroid)
    kapt(Libs.daggerHiltCompiler)

    implementation(Libs.navigationFragment)
    implementation(Libs.navigationUi)
    implementation(Libs.navigationDynamicFeaturesFragment)
    androidTestImplementation(Libs.navigationTesting)

    implementation(Libs.kotlinxSerializationJson)

    implementation(Libs.retrofit)
    implementation(Libs.gson)
    implementation(Libs.retrofitConverterGson)
    implementation(Libs.okhttp)
    implementation(Libs.retrofitConverterScalars)
    implementation(Libs.loggingInterceptor)

    implementation(Libs.coil)
}

kapt {
    correctErrorTypes = true
}

EOF

# Create the consumer-rules.pro file
touch $MODULE_PATH/consumer-rules.pro

# Create the proguard-rules.pro file
touch $MODULE_PATH/proguard-rules.pro


# Create the consumer-rules.pro file
touch $MODULE_INTERFACE_PATH/consumer-rules.pro

# Create the proguard-rules.pro file
touch $MODULE_INTERFACE_PATH/proguard-rules.pro

# Create the default AndroidManifest.xml file
cat <<EOF > $MODULE_PATH/src/main/AndroidManifest.xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="$PACKAGE_NAME">

</manifest>
EOF

# Create the default AndroidManifest.xml file
cat <<EOF > $MODULE_INTERFACE_PATH/src/main/AndroidManifest.xml
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    package="$PACKAGE_PACKAGE_NAME_INTERFACE">

</manifest>
EOF

function capitalize {
  echo "$1" | awk '{print toupper(substr($0, 1, 1)) substr($0, 2)}'
}

function capitalize_all {
  echo "$1" | tr '[:lower:]' '[:upper:]'
}

ACTIVITY_NAME="$(capitalize "$MODULE_NAME")Activity"
ACTIVITY_LAYOUT_NAME="activity_$MODULE_NAME"

ACTIVITY="$ACTIVITY_NAME.kt"
ACTIVITY_LY="$ACTIVITY_LAYOUT_NAME.xml"

# Create the MainActivity.java file
ACTIVITY_BINDING="Activity$(capitalize "$MODULE_NAME")""Binding"

cat <<EOF > $MODULE_PATH/src/main/java/$PACKAGE_NAME/presentation/ui/activity/$ACTIVITY
package $PACKAGE_NAME.presentation.ui.activity;

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.common.baseComponent.ui.base.BaseActivity
import com.example.common.navigation.UserStatus
import com.example.common.navigation.routingManager.RoutingManager
import com.example.common.navigation.sessionManager.SessionManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import com.example.$MODULE_NAME.databinding.$ACTIVITY_BINDING



@AndroidEntryPoint
class $ACTIVITY_NAME : BaseActivity() {

  @Inject
    lateinit var routeManager : RoutingManager

    @Inject
    lateinit var sessionManager: SessionManager

    override val baseBinding: $ACTIVITY_BINDING by lazy {
        $ACTIVITY_BINDING.inflate(layoutInflater)
    }

    companion object {
        const val data_key = "$(capitalize_all "$MODULE_NAME")_EXTRA"
        fun newIntent(context: Context, params: Any? = null): Intent {
            return Intent(context, $ACTIVITY_NAME::class.java).apply {
                putExtra(data_key,params.let { it as String? })
            }
        }

    }


    private lateinit var binding : $ACTIVITY_BINDING
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = $ACTIVITY_BINDING.inflate(layoutInflater)
        setContentView(binding.root)

    }
  }
EOF

# Create the activity_main.xml file
cat <<EOF > $MODULE_PATH/src/main/res/layout/$ACTIVITY_LY
<?xml version="1.0" encoding="utf-8"?>
<layout>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent">



</androidx.constraintlayout.widget.ConstraintLayout>
</layout>
EOF

# Create the module object file
MODULE_OBJ="$(capitalize "$MODULE_NAME")Module"
MODULE_INTERFACE="$(capitalize "$MODULE_NAME")ModuleInterface"

COMMON_PATH="feature/"$MODULE_NAME"Interface/src/main/java"
COMMON_INTERFACES_PACKAGE="com.example."$MODULE_NAME"Interface"

cat <<EOF > $MODULE_PATH/src/main/java/$PACKAGE_NAME/$MODULE_OBJ.kt
package $PACKAGE_NAME

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.navigation.navigator.FeatureNotEnabledException
import com.example.navigation.navigator.UnregisteredRouteException
import com.example.common.navigation.UserStatus
import com.example.common.navigation.Module
import com.example.test.presentation.ui.activity.$ACTIVITY_NAME
import com.example.common.navigation.navigationManager.NavigationManager
import $COMMON_INTERFACES_PACKAGE.$MODULE_INTERFACE

object $MODULE_OBJ  : Module {
    override val name: String
        get() = $MODULE_INTERFACE.MODULE_NAME
    override val isEnabled: Boolean
        get() = $MODULE_INTERFACE.isEnabled
    override val version: String
        get() = "1.0.0"

    override fun getRouteSupportedStatuses(route: NavigationManager.Route): ArrayList<UserStatus> {
        return arrayListOf(UserStatus.UNROLLED)
    }

    override fun provideIntentFor(context: Context, functionality: String, extra: Bundle?): Intent {
        val route = $MODULE_INTERFACE.Routes.createRouteConvertible(
            accessPoint = functionality,
            parameters = extra
        )
        return when (route) {
            is $MODULE_INTERFACE.Routes.Main -> {
                if (isEnabled) {
                    $ACTIVITY_NAME.newIntent(context)
                }
                else {
                    throw FeatureNotEnabledException("Feature not enabled")
                }
            }

            else -> throw UnregisteredRouteException("No access point declared.")
        }
    }
}
EOF



# Create class interface
cat <<EOF > $COMMON_PATH/$COMMON_INTERFACES_PACKAGE/$MODULE_INTERFACE.kt
package $COMMON_INTERFACES_PACKAGE

import android.os.Bundle
import com.example.common.navigation.RouteConvertible
import com.example.common.navigation.navigationManager.NavigationManager
import com.example.navigation.navigator.UnregisteredRouteException
import java.security.InvalidParameterException
import kotlin.jvm.Throws

class $MODULE_INTERFACE {
    companion object {
        const val MODULE_NAME = "$(capitalize_all "$MODULE_NAME")"
        var isEnabled = true
    }

    class Routes {
        enum class RoutesTypes {
            MAIN
        }

        class Main: RouteConvertible {
            override fun route(): NavigationManager.Route {
                return NavigationManager.Route(
                    module = MODULE_NAME,
                    functionality = RoutesTypes.MAIN.name,
                    extra = null
                )
            }
        }

        companion object {
            @Throws(UnregisteredRouteException::class, InvalidParameterException::class)
            fun createRouteConvertible(
                accessPoint: String,
                fromModule: String? = null,
                parameters: Bundle? = null
            ): RouteConvertible {
                return when(accessPoint){
                    RoutesTypes.MAIN.name -> Main()
                    else -> throw UnregisteredRouteException("No route found that matches the required access point $accessPoint in $MODULE_NAME")
                }
            }
        }
    }
}
EOF



# Add the module to the project's settings
echo "include(\":feature:$MODULE_NAME\")" >> settings.gradle.kts

# Add the module to the project's settings
echo "include(\":feature:$INTERFACE_MODULE_SET\")" >> settings.gradle.kts

# Create .gitignore file
echo "/build" > feature/$MODULE_NAME/.gitignore

# Create .gitignore file
echo "/build" > feature/$INTERFACE_MODULE_SET/.gitignore



echo -e '🧙' "Module '$MODULE_NAME' with package '$PACKAGE_NAME' created successfully as an Android library and added to the 'feature' directory!"

echo -e '⚠' "\033[4mPLEASE \033[1mSYNC\033[0m THE PROJECT!\033[0m"

echo -e '⚠' "\033[4mPLEASE ADD YOUR FILES TO \033[1mGIT\033[0m!\033[0m"