export default function () {
  return {
    questionnaires: [
      {
        id: Number,
        title: String,
        questions: [
          {
            id: Number,
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
