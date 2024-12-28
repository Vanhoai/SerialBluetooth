package org.ic.life.main.presentation.views.started

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.ic.life.main.presentation.common.graphs.NavRoute
import org.ic.life.main.presentation.widgets.AppScaffold

@Composable
fun StartedView(
    navController: NavController,
    onOpenDrawer: () -> Unit
) {
    AppScaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    IconButton(
                        onClick = onOpenDrawer,
                        content = {
                            Icon(
                                imageVector = Icons.Filled.Menu,
                                contentDescription = "Menu",
                                tint = Color.White
                            )
                        }
                    )
                },
                backgroundColor = Color.Black,
                elevation = 0.dp
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .safeDrawingPadding()
                    .fillMaxSize()
                    .padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Button(onClick = {
                    navController.navigate(NavRoute.SWIPE.path)
                }
                ) {
                    Text(
                        "Started View",
                        color = Color.White
                    )
                }
            }
        }
    )
}