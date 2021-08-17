package ui.components


import react.*
import react.dom.div
import react.dom.h2

fun RBuilder.rowCategory(handler: RowCategoryProps.() -> Unit): ReactElement {
    return child(RowCategory) {
        this.attrs(handler)
    }
}

external interface RowCategoryProps : RProps {
    var title: String
    var fetchUrl: String
}


private val RowCategory = functionalComponent<RowCategoryProps> { props ->
    div {
        h2 {
            +props.title
        }
        posterItem {
            fetchUrl = props.fetchUrl
        }
    }
}