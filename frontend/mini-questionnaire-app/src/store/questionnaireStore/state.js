export default function () {
  return {
    questionnaires: [
      {
        id: Number,
        title: String,
        questions: [
          {
            id: Number,
            hasMultipleAnswers: Boolean,
            description: String,
            answerOptions: [
              {
                id: Number,
                description: String
              }
            ]
          }
        ]
      }
    ]
  }
}
