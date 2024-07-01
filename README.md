# Movie Matrix

<img src="https://github.com/Bhupendrapatel98/Movie-Matrix/assets/55411086/586627ad-6043-431e-9e7c-04c2f205e265" alt="Image 1" width="100">
<img src="https://github.com/Bhupendrapatel98/Movie-Matrix/assets/55411086/3f17a9e6-d2b1-4b22-abf0-a18ea4eaa120" alt="Image 1" width="100" >
<img src="https://github.com/Bhupendrapatel98/Movie-Matrix/assets/55411086/2b12d6c2-0b43-4f4a-9fb8-bcd6bf64fe17" alt="Image 1" width="100">
<img src="https://github.com/Bhupendrapatel98/Movie-Matrix/assets/55411086/0774faae-8ea1-4157-96d5-d33aa280e459" alt="Image 1" width="100">

## Introduction

**Movie Matrix** is a demo application that provides detailed information about movies. It fetches data from the TMDB (The Movie Database) API, offering users an intuitive and seamless experience. The app is built using the latest Android development tools and practices.

## Features

- **Movie Information**: Browse and search for movies, view detailed information including ratings, cast, and reviews.
- **Smooth UI**: Leveraging Jetpack Compose for a modern, declarative UI.
- **Efficient Data Handling**: Utilizes Paging 3 for efficient data loading and caching.
- **Robust Architecture**: Built with MVVM and Clean Architecture principles.
- **Offline Support**: Data caching with Room database to support offline access.
- **Continuous Integration/Continuous Deployment (CI/CD)**: Automated build and deployment pipeline.
- **Quality Assurance**: Comprehensive unit testing for reliability.

## Technology Stack

- **Language**: Kotlin
- **UI**: Jetpack Compose
- **Networking**: Retrofit
- **Dependency Injection**: Dagger Hilt
- **Concurrency**: Coroutines and Flow
- **Data Storage**: Room Database
- **Paging**: Paging 3 with RemoteMediator
- **Architecture**: MVVM and Clean Architecture
- **CI/CD**: Integrated CI/CD pipeline
- **Code Quality**: Lint for static code analysis

## Project Setup

To set up the project locally, follow these steps:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/your-username/MovieMatrix.git
   cd MovieMatrix

2. **Open the project in Android Studio**:
  - Ensure you have Android Studio Arctic Fox or later.
   
3. **Get TMDB API Key**:
  - Sign up at TMDB and get your API key.
  - Add the API key to your local.properties file:
    ```bash
    TMDB_API_KEY=your_api_key_here
       
4. **Build and Run**:
  - Sync the project with Gradle files.
  - Run the app on an emulator or a physical device.

## Continuous Integration
The project includes a CI/CD pipeline using GitHub Actions. The pipeline automatically builds and tests the app on every push to the repository.

## Testing
   ./gradlew test

## Contributing
Contributions are welcome! Please follow these steps:

 - Fork the repository.
 - Create a new branch (git checkout -b feature/YourFeature).
 - Commit your changes (git commit -am 'Add some feature').
 - Push to the branch (git push origin feature/YourFeature).
 - Create a new Pull Request.

## Contact
For any inquiries, please contact:

 - Email: Bhupendra.bp57@gmail.com
 - GitHub: BhupendraPate98
