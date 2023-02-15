package ludugz.simplegithubclient.ui.userslist.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import ludugz.simplegithubclient.domain.models.UserDetailBO

@Composable
fun UserListRowComponent(
    user: UserDetailBO,
    onItemClick: (UserDetailBO) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(10.dp))
        .clickable { onItemClick(user) }
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = user.avatarUrl),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(text = user.name, style = MaterialTheme.typography.headlineMedium)
    }
    Spacer(modifier = Modifier.height(8.dp))
    Divider(modifier = Modifier.height(1.dp))
    Spacer(modifier = Modifier.height(8.dp))
}

@Preview(
    name = "Preview User List Row Component",
    widthDp = 300,
    heightDp = 150,
    locale = "ja",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    device = Devices.PIXEL_4
)
@Composable
fun PreviewUserListRowComponent() {
    UserListRowComponent(
        user = UserDetailBO("Dummy", "Dummy", "Dummy", "Dummy"),
        onItemClick = { })
}