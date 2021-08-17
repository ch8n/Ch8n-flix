import kotlinx.browser.document
import react.dom.*


fun main() {
    render(document.getElementById("root")) {
        div {
            h1 {
                +"Netflix Clone"
            }
            div {
                h3 {
                    +"Videos to watch"
                }
                p {
                    +"John Doe: Building and breaking things"
                }
                p {
                    +"Jane Smith: The development process"
                }
                p {
                    +"Matt Miller: The Web 7.0"
                }

                h3 {
                    +"Videos watched"
                }
                p {
                    +"Tom Jerry: Mouseless development"
                }
            }
            div {
                h3 {
                    +"John Doe: Building and breaking things"
                }
                img {
                    attrs {
                        src = "https://via.placeholder.com/640x360.png?text=Video+Player+Placeholder"
                    }
                }
            }
        }
    }
}