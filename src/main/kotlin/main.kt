import kotlinx.browser.document
import react.dom.h1
import react.dom.render

fun main() {
    document.bgColor = "blue"
    render(document.getElementById("root")) {
        h1 {
            +"Hello, React+Kotlin/JS!"
        }
    }
}