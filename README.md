# PokemonBox

**PokemonBox** is an Android application written in Kotlin that allows users to browse and search for Pokémon data provided by the [PokeAPI](https://pokeapi.co). The project follows Clean Architecture principles and a modular design, ensuring clear separation of concerns, high testability, and ease of maintenance.

---

## Project Structure

The project is organized into several modules, each with a distinct responsibility:

- **app**  
  The main application module containing the entry point, navigation (using Android’s Navigation Component with Safe Args), and Hilt integration for dependency injection.

- **domain**  
  Contains the business logic, use cases, and domain models.  
  - **pokemon/model**: Defines the domain model for a Pokémon.  
  - **pokemon/repository**: Declares the `PokemonRepository` interface that defines contracts for data access.  
  - **pokemon/usecase**: Contains use cases such as `GetPokemonsUseCase` and `SearchPokemonUseCase`.

- **data**  
  Implements the repository and data access via REST API calls using Retrofit and OkHttp.  
  - Handles mapping from Data Transfer Objects (DTOs) to domain models.  


- **pokemonList**  
  The module dedicated to the presentation of the Pokémon list.  
  - Contains Activity/Fragment, custom view (e.g., `PokemonItemView` for displaying each list item), and a ViewModel that implements the MVI (Model-View-Intent) pattern to manage state and user intents.
  
- **common**  
  Contains shared components, utilities, and extension functions used across multiple modules.

---

## Architecture and Patterns

- **Clean Architecture:**  
  The project is divided into Domain, Data, and Presentation layers. This separation ensures that business logic is independent of platform-specific details and can be tested easily.

- **MVI (Model-View-Intent):**  
  The presentation layer uses the MVI pattern to manage unidirectional data flow between the UI and the ViewModel. User actions (Intents) are sent to the ViewModel, which processes them and updates a StateFlow that the UI observes.

- **Dependency Injection with Hilt:**  
  Hilt is used throughout the project for dependency injection, making the code modular and easier to test.

- **Networking with Retrofit and OkHttp:**  
  Retrofit is used to make REST API calls to the PokeAPI, while OkHttp (with a Logging Interceptor) helps monitor network traffic. An additional API call is made to `/pokemon-species/{name}` to retrieve a Pokémon’s description. For each Pokémon, details and the corresponding description (filtered for the "shield" version in English) are fetched concurrently.

- **Kotlin Coroutines for Asynchronous Operations:**  
  Coroutines handle asynchronous network calls and data loading efficiently. For example, concurrent calls are used to retrieve Pokémon details and their enriched descriptions.

- **View Binding and Data Binding:**  
  These features ensure type-safe access to views and help reduce boilerplate code.

---

## Testing

Unit tests are included to verify the business logic of the application. Tests cover the use cases (such as `GetPokemonsUseCase` and `SearchPokemonUseCase`). They are implemented using JUnit and `kotlinx-coroutines-test`. You can run these tests using the command:

