package ui.components

import data.models.KPoster
import react.*
import react.dom.div
import react.dom.img


fun RBuilder.posterItem(handler: PosterItemProps.() -> Unit): ReactElement {
    return child(PosterItem::class) {
        this.attrs(handler)
    }
}

external interface PosterItemProps : RProps {
    var posters: List<KPoster>
}

@JsExport
class PosterItem : RComponent<PosterItemProps, RState>() {
    override fun RBuilder.render() {
        div {
            props.posters.forEach {
                img {
                    attrs {
                        key = it.id.toString()
                        src = it.imageUrl
                        alt = it.name
                    }
                }
            }
        }
    }
}