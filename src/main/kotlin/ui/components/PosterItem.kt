package ui.components

import androidx.compose.runtime.*
import data.models.PosterResponse
import data.remote.api.AppApis
import data.repositories.PosterRepository
import kotlinx.browser.window
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.await
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.AttrsBuilder
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.css.selectors.CSSSelector
import org.jetbrains.compose.web.css.selectors.attr
import org.jetbrains.compose.web.dom.*
import org.w3c.dom.HTMLHeadingElement


@Composable
fun PosterItem() {

    val (msg, setMsg) = remember { mutableStateOf("Api call in process...") }
    val scope = rememberCoroutineScope()

    Button(
        attrs = {
            style {
                color(Color.red)
            }
            onClick {
                scope.launch {
                    val repo = PosterRepository()
                    val categories = repo.getCategories()
                    val category = categories.get(0)
                    val categoryFetchUrl = "${AppApis.BASE_URL}${category.categoryFetchUrl}"
                    val posterItems = httpGet<PosterResponse>(categoryFetchUrl)
                    setMsg(posterItems?.results?.toString()?:"Response failed")
                }
            }
        }
    ) {
        Text("retry")
    }
    Br()
    Text(msg)
}

suspend fun <T> httpGet(url: String): T? {
    val response = runCatching {
        val response = window.fetch(url).await()
        val jsonString = JSON.stringify(response.json().await())
        JSON.parse(jsonString) as T
    }
    return response.getOrNull()
}