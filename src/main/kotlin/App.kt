import data.models.RowCategory
import data.repositories.PosterRepository
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.dom.div
import react.dom.h1
import ui.components.rowCategory

@JsExport
class App : RComponent<RProps, RState>() {

    private val repository = PosterRepository()

    override fun RBuilder.render() {
        div {
            h1 {
                +"Netflix Clone"
            }
            repository.getCategories().get(0).let { listOf(it) }
                .forEach { category: RowCategory ->
                    rowCategory {
                        title = category.title
                        fetchUrl = category.categoryFetchUrl
                    }
                }
        }
    }
}