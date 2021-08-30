



# Netflix-Clone-React
Practising React by building Netflix Clone

# Requirements

- [TMDB api key](https://www.themoviedb.org/) : Add TMDB API key
  to [AppApi.kt](src/main/kotlin/data/remote/apis/AppApis.kt)

# Learning Resourcce

[Build Netflix clone](https://www.youtube.com/watch?v=XtMThy8QKqU)

[Official Kotlin-React](https://play.kotlinlang.org/hands-on/Building%20Web%20Applications%20with%20React%20and%20Kotlin%20JS/01_Introduction)

# Features

- [Kotlin-React](https://github.com/JetBrains/kotlin-wrappers/tree/master/kotlin-react)
- [Kotlin-Styled-Component](https://github.com/JetBrains/kotlin-wrappers/tree/master/kotlin-styled)
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html)
- [Modern React](https://play.kotlinlang.org/hands-on/Building%20Web%20Applications%20with%20React%20and%20Kotlin%20JS/10_Addendum_Modern_React_with_Hooks)
  - `useState`, `useEffect`, `functional-components`

# Preview

https://user-images.githubusercontent.com/11576342/128147565-1ee0aec8-67da-46ac-afd7-0a686a9bb594.mov

# Project Structure

```
netflix-clone/src/main
├── kotlin
│   ├── App.kt
│   ├── data
│   │   ├── models
│   │   │   └── AppModels.kt
│   │   ├── remote
│   │   │   └── apis
│   │   │       └── AppApis.kt
│   │   └── repositories
│   │       └── PosterRepository.kt
│   ├── main.kt
│   ├── ui
│   │   └── components
│   │       ├── Banner.kt
│   │       ├── Header.kt
│   │       ├── PosterItem.kt
│   │       └── RowCategory.kt
│   └── utils
│       └── EnvSetup.kt
└── resources
    ├── images
    │   ├── avatar.png
    │   └── netflix.png
    └── index.html

```

# Getting Started with Project

### Gradle > Kotlin Browser > browserDevelopmentRun

Runs the app in the development mode.\
Open [http://localhost:8080](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.\
You will also see any lint errors in the console.

# MIT License

Copyright (c) 2021 Chetan Gupta

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
