package ui.components

import data.models.KPoster
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

    val (poster, setPoster) = useState(listOf<KPoster>())

    useEffect(listOf(props.fetchUrl)) {
        GlobalScope.launch {
            val response = kotlin.runCatching {
                val json = window.fetch("${AppApis.BASE_URL}/${props.fetchUrl}").await().json().await()
                println(json)
                json as? List<KPoster>
            }
            if (response.isSuccess) {
                val result: List<KPoster> = response.getOrNull() ?: emptyList()
                setPoster(result)
            }
        }
    }

    div {
        poster.forEach {
            img {
                attrs {
                    key = it.id.toString()
                    src = "${AppApis.BASE_POSTER_URL}/w500/${it.imageUrl}"
                    alt = it.name
                }
            }
        }
    }
}
