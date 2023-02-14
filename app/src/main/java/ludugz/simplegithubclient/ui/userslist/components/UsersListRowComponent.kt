package ludugz.simplegithubclient.ui.userslist.components

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ludugz.simplegithubclient.domain.models.UserDetailBO

@Composable
fun UserListRowComponent(
    user: UserDetailBO,
    onItemClick: (UserDetailBO) -> Unit
) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .clickable {
            onItemClick(user)
        }) {
        Text(text = user.name, style = MaterialTheme.typography.bodyMedium)
    }
    Spacer(modifier = Modifier.height(4.dp))
    Divider(modifier = Modifier.height(2.dp))
    Spacer(modifier = Modifier.height(4.dp))
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
        user = UserDetailBO("Dummy Name", "Dummy Location"),
        onItemClick = { })
}