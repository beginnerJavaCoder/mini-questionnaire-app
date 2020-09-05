export function getAllQuestionnaires (state) {
  return state.questionnaires
}

export function getAllTitles (state) {
  const titles = []
  for (let i = 0; i < state.questionnaires.length; i++) {
    titles.push(state.questionnaires[i].title)
  }
  return titles
}
