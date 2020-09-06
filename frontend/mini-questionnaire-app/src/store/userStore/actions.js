export async function fetchUserInfo (context, request) {
  const response = await fetch('http://localhost:8080/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(request)
  })
  if (response.ok) {
    const userInfo = await response.json()
    context.commit('updateUserInfo', userInfo)
    return true
  } else {
    return false
  }
}

export function deleteUserInfo (context) {
  context.commit('deleteUserInfo')
}
