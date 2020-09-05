export function updateUserInfo (state, userInfo) {
  state.userInfo = userInfo
}

export function deleteUserInfo (state) {
  state.userInfo.token = ''
  state.userInfo.username = String
  state.userInfo.userId = Number
  state.userInfo.roles = []
}
