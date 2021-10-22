



# Netflix-Clone-React
Netflix inspired Home Screen build using Jetpack Compose Web 🕸

# Requirements

>[TMDB api key](https://www.themoviedb.org/) : Add TMDB API key
  to [AppApi.kt](src/main/kotlin/data/remote/apis/AppApis.kt)

# Learning Resourcce

>[Build Netflix clone](https://www.youtube.com/watch?v=XtMThy8QKqU)
> 
>[Official Compose-Web Github](https://play.kotlinlang.org/hands-on/Building%20Web%20Applications%20with%20React%20and%20Kotlin%20JS/01_Introduction)
> 
>[theApache64-Jetpack Web Template](https://github.com/theapache64/compose-web-template)

# Features
[Jetpack-Compose-Web](https://github.com/jetbrains/compose-jb)

# Preview

https://user-images.githubusercontent.com/11576342/128147565-1ee0aec8-67da-46ac-afd7-0a686a9bb594.mov

# Project Structure
> TODO UPDATE
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
```
./gradlew jsBrowserRun
```


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
