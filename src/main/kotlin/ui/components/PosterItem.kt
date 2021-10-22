package ui.components

import androidx.compose.runtime.*
import data.remote.api.AppApis
import data.repositories.PosterRepository
import kotlinx.browser.window
import kotlinx.coroutines.await
import org.jetbrains.compose.web.css.buildCSSStyleRule
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.H3
import org.jetbrains.compose.web.dom.Text


@Composable
fun PosterItem() {

    val (msg,setMsg) = remember { mutableStateOf("Api call in process...") }

    LaunchedEffect(Unit) {
        val repo = PosterRepository()
        val categories = repo.getCategories()
        val category = categories.get(0)
        val categoryFetchUrl = "${AppApis.BASE_URL}${category.categoryFetchUrl}"
        val response = window.fetch(categoryFetchUrl).await()
        val jsonString = JSON.stringify(response.json().await())
        setMsg(jsonString)
    }

    H3 {
        Text(msg)
    }

}