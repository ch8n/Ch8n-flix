import data.models.RowCategory
import data.repositories.PosterRepository
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import ui.components.AppHeader
import ui.components.rowCategory

@JsExport
class App : RComponent<RProps, RState>() {

    private val repository = PosterRepository()

    override fun RBuilder.render() {
        div {

            AppHeader {

            }
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