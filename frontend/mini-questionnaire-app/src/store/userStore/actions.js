export async function fetchUserInfo (context, request) {
  const response = await fetch('http://localhost:8081/login', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(request)
  })
  const userInfo = await response.json()
  context.commit('updateUserInfo', userInfo)
}
