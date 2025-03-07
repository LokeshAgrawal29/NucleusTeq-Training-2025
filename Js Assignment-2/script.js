
let questions = []
let currentQuestionIndex = 0
let score = 0
let timer
let timeLeft = 15


const startScreen = document.getElementById("start-screen")
const gameScreen = document.getElementById("game-screen")
const endScreen = document.getElementById("end-screen")
const loadingScreen = document.getElementById("loading-screen")
const categorySelect = document.getElementById("category")
const difficultySelect = document.getElementById("difficulty")
const amountSelect = document.getElementById("amount")
const startBtn = document.getElementById("start-btn")
const questionNumber = document.getElementById("question-number")
const scoreElement = document.getElementById("score")
const timerBar = document.getElementById("timer-bar")
const timerText = document.getElementById("timer-text")
const questionText = document.getElementById("question-text")
const optionsContainer = document.getElementById("options-container")
const feedback = document.getElementById("feedback")
const feedbackText = document.getElementById("feedback-text")
const nextBtn = document.getElementById("next-btn")
const finalScore = document.getElementById("final-score")
const playAgainBtn = document.getElementById("play-again-btn")


startBtn.addEventListener("click", startGame)
nextBtn.addEventListener("click", loadNextQuestion)
playAgainBtn.addEventListener("click", resetGame)


async function startGame() {

  startScreen.classList.add("hidden")
  loadingScreen.classList.remove("hidden")

  const category = categorySelect.value
  const difficulty = difficultySelect.value
  let amount;
    if (difficulty === "easy") {
        amount = 10;
    } else if (difficulty === "medium") {
        amount = 15;
    } else if (difficulty === "hard") {
        amount = 20;
    }

  try {
   
    const response = await fetch(
      `https://opentdb.com/api.php?amount=${amount}&category=${category}&difficulty=${difficulty}&type=multiple`,
    )
    const data = await response.json()

    if (data.response_code === 0) {
      questions = data.results.map((question) => {

        const answers = [...question.incorrect_answers, question.correct_answer].sort(() => Math.random() - 0.5)

        return {
          question: question.question,
          answers: answers,
          correctAnswer: question.correct_answer,
        }
      })

      loadingScreen.classList.add("hidden")
      gameScreen.classList.remove("hidden")

      currentQuestionIndex = 0
      score = 0
      updateScore()

      loadQuestion()
    } else {
      throw new Error("Failed to fetch questions")
    }
  } catch (error) {
    alert("Error fetching questions. Please try again.")
    loadingScreen.classList.add("hidden")
    startScreen.classList.remove("hidden")
  }
}

function loadQuestion() {
  clearInterval(timer)

  timeLeft = 15
  timerText.textContent = timeLeft
  timerBar.style.width = "100%"

  feedback.classList.add("hidden")


  const currentQuestion = questions[currentQuestionIndex]


  questionNumber.textContent = `Question ${currentQuestionIndex + 1}/${questions.length}`

  const tempElement = document.createElement("div")
  tempElement.innerHTML = currentQuestion.question
  questionText.textContent = tempElement.textContent


  optionsContainer.innerHTML = ""

  const optionPrefixes = ["A", "B", "C", "D"]
  currentQuestion.answers.forEach((answer, index) => {
    const option = document.createElement("div")
    option.classList.add("option")

    const tempElement = document.createElement("div")
    tempElement.innerHTML = answer
    const decodedAnswer = tempElement.textContent

    option.innerHTML = `<span class="option-prefix">${optionPrefixes[index]}</span> ${decodedAnswer}`
    option.dataset.answer = answer
    option.addEventListener("click", selectAnswer)
    optionsContainer.appendChild(option)
  })


  startTimer()
}

function startTimer() {
  timer = setInterval(() => {
    timeLeft--
    timerText.textContent = timeLeft
    timerBar.style.width = `${(timeLeft / 15) * 100}%`

    if (timeLeft <= 5) {
      timerBar.style.backgroundColor = "#e74c3c"
    } else {
      timerBar.style.backgroundColor = "#3498db"
    }

    if (timeLeft <= 0) {
      clearInterval(timer)
      timeOut()
    }
  }, 1000)
}

function selectAnswer(e) {

  clearInterval(timer)

 
  const options = document.querySelectorAll(".option")
  options.forEach((option) => {
    option.removeEventListener("click", selectAnswer)
    option.style.cursor = "default"
  })


  const selectedOption = e.currentTarget
  const selectedAnswer = selectedOption.dataset.answer
  const currentQuestion = questions[currentQuestionIndex]


  const isCorrect = selectedAnswer === currentQuestion.correctAnswer

  feedback.classList.remove("hidden")

  if (isCorrect) {
    selectedOption.classList.add("correct")
    feedbackText.textContent = "Correct! Well done!"
    score++
    updateScore()
  } else {
    selectedOption.classList.add("incorrect")


    options.forEach((option) => {
      if (option.dataset.answer === currentQuestion.correctAnswer) {
        option.classList.add("correct")
      }
    })

    const tempElement = document.createElement("div")
    tempElement.innerHTML = currentQuestion.correctAnswer
    const decodedAnswer = tempElement.textContent

    feedbackText.textContent = `Incorrect! The correct answer is: ${decodedAnswer}`
  }
}

function timeOut() {

  const options = document.querySelectorAll(".option")
  options.forEach((option) => {
    option.removeEventListener("click", selectAnswer)
    option.style.cursor = "default"

    if (option.dataset.answer === questions[currentQuestionIndex].correctAnswer) {
      option.classList.add("correct")
    }
  })


  feedback.classList.remove("hidden")

  const tempElement = document.createElement("div")
  tempElement.innerHTML = questions[currentQuestionIndex].correctAnswer
  const decodedAnswer = tempElement.textContent

  feedbackText.textContent = `Time's up! The correct answer is: ${decodedAnswer}`
}

function loadNextQuestion() {
  currentQuestionIndex++

  if (currentQuestionIndex < questions.length) {
    loadQuestion()
  } else {
    endGame()
  }
}

function endGame() {
  gameScreen.classList.add("hidden")
  endScreen.classList.remove("hidden")
  finalScore.textContent = `Your Score: ${score}/${questions.length}`
}

function updateScore() {
  scoreElement.textContent = `Score: ${score}`
}

function resetGame() {
  endScreen.classList.add("hidden")
  startScreen.classList.remove("hidden")
}

function decodeHTML(html) {
  const txt = document.createElement("textarea")
  txt.innerHTML = html
  return txt.value
}