export async function fetchStatistics (context, token) {
  const response = await fetch('http://localhost:8081/users/statistics', {
    headers: {
      'Content-Type': 'application/json',
      Authorization: 'Bearer ' + token
    }
  }
  )
  if (response.ok) {
    const statistics = await response.json()
    context.commit('updateStatistics', statistics)
  }
}
