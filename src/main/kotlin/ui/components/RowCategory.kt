package ui.components

import data.models.KPoster
import react.*
import react.dom.div
import react.dom.h2

fun RBuilder.rowCategory(handler: RowCategoryProps.() -> Unit): ReactElement {
    return child(RowCategory::class) {
        this.attrs(handler)
    }
}

external interface RowCategoryProps : RProps {
    var title: String
    var posters: List<KPoster>
}

@JsExport
class RowCategory : RComponent<RowCategoryProps, RState>() {
    override fun RBuilder.render() {
        div {
            h2 {
                +props.title
            }
            posterItem {
                posters = props.posters
            }
        }
    }
}