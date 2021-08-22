package ui.components

import data.models.PosterResponse
import data.remote.apis.AppApis
import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import kotlinx.css.*
import kotlinx.css.properties.ms
import kotlinx.css.properties.scale
import kotlinx.css.properties.transform
import kotlinx.css.properties.transition
import react.*
import react.dom.img
import styled.css
import styled.styledDiv

external interface PosterItemProps : RProps {
    var fetchUrl: String
    var isStyleBackDrop: Boolean
}

fun RBuilder.posterItem(handler: PosterItemProps.() -> Unit): ReactElement {
    return child(PosterItem) {
        this.attrs(handler)
    }
}


private val PosterItem = functionalComponent<PosterItemProps> { props ->

    val (poster, setPoster) = useState<PosterResponse?>(null)

    useEffect(listOf(props.fetchUrl)) {
        GlobalScope.launch {
            val response = kotlin.runCatching {
                val json = window.fetch("${AppApis.BASE_URL}${props.fetchUrl}").await().json().await()
                val jsonString = JSON.stringify(json)
                JSON.parse<PosterResponse>(jsonString)
            }
            if (response.isSuccess) {
                val result: PosterResponse = requireNotNull(response.getOrNull())
                setPoster(result)
            } else {
                console.error(response.exceptionOrNull())
            }
        }
    }

    styledDiv {

        css {
            display = Display.flex
            flexDirection = FlexDirection.row
            overflowX = Overflow.scroll
            overflowY = Overflow.hidden
            padding(top = 10.px, bottom = 10.px, left = 10.px)

            // custom rule
            rule("&::-webkit-scrollbar") {
                display = Display.none
            }

            children("img") {
                objectFit = ObjectFit.contain
                width = 100.pct // 100%
                maxHeight = 240.px
                maxWidth = 360.px
                margin(right = 10.px)
                transition(property = "transform", duration = 450.ms)
                hover {
                    transform {
                        scale(1.09)
                    }
                }
            }
        }

        (poster?.results?.toList() ?: emptyList())
            .forEach {
                img {
                    attrs {
                        key = requireNotNull(it.id?.toString())
                        src = when {
                            props.isStyleBackDrop -> "${AppApis.BASE_POSTER_URL}/w500/${it.backdrop_path}"
                            else -> "${AppApis.BASE_POSTER_URL}/w500/${it.poster_path}"
                        }
                        alt = it.name ?: "error "
                    }
                }
            }
    }
}

