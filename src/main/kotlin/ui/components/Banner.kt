package ui.components

import data.models.Poster
import data.models.PosterResponse
import data.remote.apis.AppApis
import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.css.properties.LineHeight
import react.*
import react.dom.button
import styled.css
import styled.styledDiv
import styled.styledH1
import styled.styledHeader

fun RBuilder.Banner(handler: RProps.() -> Unit): ReactElement {
    return child(Banner) {
        this.attrs(handler)
    }
}


private val Banner = functionalComponent<RProps> { props ->

    val (banner, setBanner) = useState<Poster?>(null)

    useEffect(emptyList()) {
        GlobalScope.launch {
            val response = kotlin.runCatching {
                val json = window.fetch("${AppApis.BASE_URL}${AppApis.GET_NETFLIX_ORIGINAL}").await().json().await()
                val jsonString = JSON.stringify(json)
                JSON.parse<PosterResponse>(jsonString)
            }
            if (response.isSuccess) {
                val result: PosterResponse = requireNotNull(response.getOrNull())
                setBanner(result.results.random())
            } else {
                console.error(response.exceptionOrNull())
            }
        }
    }

    styledHeader {
        css {
            backgroundSize = "cover"
            put("backgroundImage", "url(\"${AppApis.BASE_POSTER_URL}/original/${banner?.backdrop_path}\")")
            console.log("${AppApis.BASE_POSTER_URL}/original/${banner?.backdrop_path}")
            backgroundPosition = "center center"
            color = Color.white
            objectFit = ObjectFit.contain
            height = 450.px
        }

        styledDiv {
            css {
                marginLeft = 30.px
                padding(top = 140.px)
                height = 200.px
            }

            styledH1 {
                css {
                    fontSize = 3.em
                    fontWeight = FontWeight("800")
                    padding(bottom = 0.3.rem)
                }
                +(banner?.name ?: banner?.title ?: banner?.original_name ?: "Error")
            }

            styledDiv {
                css {
                    display = Display.flex
                }
                button {
                    +"Play"
                }
                button {
                    +"More Info"
                }
            }

            styledH1 {
                css {
                    width = 45.em
                    lineHeight = LineHeight("1.3")
                    padding(top = 1.rem)
                    fontSize = 1.rem
                    maxWidth = 360.px
                    height = 80.px
                }
                val overView = banner?.overview ?: "N/A"
                val formatted = if (overView.length > 200) {
                    "${overView.take(200)}..."
                } else {
                    overView
                }
                +formatted
            }

        }

        styledDiv {
            css {
                height = 7.8.rem
                put("background-image", "linear-gradient(180deg,transparent,rgba(37,37,37,0.61),#111)")
            }
        }
    }
}