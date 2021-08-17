package ui.components

import data.models.KPoster
import data.remote.apis.AppApis
import kotlinext.js.asJsObject
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

    val (poster, setPoster) = useState<KPoster?>(null)

    useEffect(listOf(props.fetchUrl)) {
        GlobalScope.launch {
            val response = kotlin.runCatching {
                val json = window.fetch("${AppApis.BASE_URL}${props.fetchUrl}").await().json().await()
                console.log(json?.asJsObject())
                (json as? KPoster) ?: throw NullPointerException("Parsing failed")
            }
            if (response.isSuccess) {
                val result: KPoster = requireNotNull(response.getOrNull())
                console.log("Success")
                console.log(result)
                setPoster(result)
            } else {
                console.log(response.exceptionOrNull())
            }
        }
    }

    div {
        (poster?.results ?: emptyList())
            .filter { it.id != null }
            .also { console.log(it.asJsObject()) }
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
