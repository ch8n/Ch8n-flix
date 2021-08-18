package ui.components

import data.models.Poster
import data.models.PosterResponse
import data.remote.apis.AppApis
import kotlinx.browser.window
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import react.*
import react.dom.div
import react.dom.img

external interface PosterItemProps : RProps {
    var fetchUrl: String
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

    div {
        (poster?.results?.toList() ?: emptyList<Poster>())
            .forEach {
                img {
                    attrs {
                        key = requireNotNull(it.id?.toString())
                        src = "${AppApis.BASE_POSTER_URL}/w500/${it.poster_path}"
                        alt = requireNotNull(it.name)
                    }
                }
            }
    }
}

