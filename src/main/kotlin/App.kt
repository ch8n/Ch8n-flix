import data.models.RowCategory
import data.repositories.PosterRepository
import kotlinx.css.*
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import styled.css
import styled.styledDiv
import ui.components.AppHeader
import ui.components.Banner
import ui.components.rowCategory

@JsExport
class App : RComponent<RProps, RState>() {

    private val repository = PosterRepository()

    override fun RBuilder.render() {
        styledDiv {
            css {
                padding(all = 0.px)
                margin(all = 0.px)
                backgroundColor = Color("#111")
            }
            AppHeader { }
            Banner { }
            repository.getCategories()
                .forEach { category: RowCategory ->
                    rowCategory {
                        title = category.title
                        fetchUrl = category.categoryFetchUrl
                        isStyleBackDrop = category.isStyleBackDrop
                    }
                }
        }
    }
}