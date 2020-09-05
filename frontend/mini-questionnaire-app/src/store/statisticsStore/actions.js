export async function fetchStatistics (context, token) {
  const response = await fetch('http://localhost:8081/users/questionnaires?userId=3', {
    headers: {
      'Content-Type': 'application/json',
      Authorization: 'Bearer ' + token
    }
  }
  )
  if (response.ok) {
    const answers = await response.json()
    context.commit('updateStatistics', answers)
  }
}
