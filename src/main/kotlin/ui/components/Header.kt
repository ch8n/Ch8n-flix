package ui.components

import kotlinx.browser.window
import kotlinx.css.*
import kotlinx.css.properties.s
import kotlinx.css.properties.transition
import org.w3c.dom.events.Event
import react.*
import styled.css
import styled.styledDiv
import styled.styledImg


const val netflixIcon: String = "./images/netflix.png"
const val profileIcon: String = "./images/avatar.png"

fun RBuilder.AppHeader(handler: RProps.() -> Unit): ReactElement {
    return child(Header) {
        this.attrs(handler)
    }
}


private val Header = functionalComponent<RProps> { props ->
    val (isToolbarBlack, setToolBarBlack) = useState<Boolean>(false)

    useEffectWithCleanup(emptyList()) {
        val onScrollChange = { _: Event ->
            when {
                window.scrollY > 100 -> setToolBarBlack(true)
                else -> setToolBarBlack(false)
            }
        }
        window.addEventListener(type = "scroll", callback = onScrollChange)

        return@useEffectWithCleanup {
            window.removeEventListener(type = "scroll", callback = onScrollChange)
        }
    }

    styledDiv {
        css {
            backgroundColor = if (isToolbarBlack) {
                Color("#111")
            } else {
                Color.transparent
            }
            position = Position.fixed
            top = 0.px
            height = 80.px
            width = 100.pct
            display = Display.flex
            justifyContent = JustifyContent.spaceBetween
            zIndex = 1
            transition(property = "all", duration = 0.5.s)
        }

        styledImg {
            css {
                height = 80.px
                objectFit = ObjectFit.contain
            }
            attrs {
                src = netflixIcon
                alt = "Ch8nFlix"
            }
        }


        styledImg {
            css {
                padding(all = 20.px)
                height = 42.px
                objectFit = ObjectFit.contain
            }
            attrs {
                src = profileIcon
                alt = "Profile"
            }
        }

    }
}
