package ui.components

import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import org.w3c.dom.events.Event
import react.*
import react.dom.img
import styled.css
import styled.styledDiv


// TODO fix
const val netflixIcon: String = "src/resources/images/netflix.png"
const val profileIcon: String = "src/resources/images/avatar.png"

fun RBuilder.AppHeader(handler: RProps.() -> Unit): ReactElement {
    return child(Header) {
        this.attrs(handler)
    }
}


private val Header = functionalComponent<RProps> { props ->
    val (isToolbarBlack, setToolBarBlack) = useState<Boolean>(false)
    useEffect(emptyList()) {
        val onScrollChange = { _: Event ->
            when {
                window.scrollY > 100 -> setToolBarBlack(true)
                else -> setToolBarBlack(false)
            }
        }
        window.addEventListener(type = "scroll", callback = onScrollChange)

        return@useEffect window.removeEventListener(type = "scroll", callback = onScrollChange)
    }

    styledDiv {
        css {
            position = Position.fixed
            top = 0.px
            height = 80.px
            width = 100.pct
            display = Display.flex
            justifyContent = JustifyContent.spaceBetween
            zIndex = 1
            transition(property = "all", duration = 0.5.s)
        }


        img {
            attrs {
                src = netflixIcon
                alt = "Ch8nFlix"
            }
        }

        img {
            attrs {
                src = profileIcon
                alt = "Profile"
            }
        }

    }
}
