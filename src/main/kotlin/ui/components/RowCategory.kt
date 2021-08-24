package ui.components


import kotlinx.css.Color
import kotlinx.css.color
import kotlinx.css.margin
import kotlinx.css.px
import react.*
import react.dom.div
import styled.css
import styled.styledH2

fun RBuilder.rowCategory(handler: RowCategoryProps.() -> Unit): ReactElement {
    return child(RowCategory) {
        this.attrs(handler)
    }
}

external interface RowCategoryProps : RProps {
    var title: String
    var fetchUrl: String
    var isStyleBackDrop: Boolean
}


private val RowCategory = functionalComponent<RowCategoryProps> { props ->
    div {
        styledH2 {
            css {
                color = Color.white
                margin(left = 20.px)
            }
            +props.title
        }
        posterItem {
            fetchUrl = props.fetchUrl
            isStyleBackDrop = props.isStyleBackDrop
        }
    }
}