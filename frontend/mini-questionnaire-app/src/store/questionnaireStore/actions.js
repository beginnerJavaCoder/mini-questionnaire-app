export async function fetchQuestionnaires (context, token) {
  const response = await fetch('http://localhost:8080/questionnaires', {
    headers: {
      'Content-Type': 'application/json',
      Authorization: 'Bearer ' + token
    }
  }
  )
  if (response.ok) {
    const questionnaires = await response.json()
    context.commit('updateQuestionnaires', questionnaires)
  }
}
