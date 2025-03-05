let scores = [0, 0], currentScore = 0, activePlayer = 0;

function rollDice() {
    let roll = Math.floor(Math.random() * 6) + 1;
    document.getElementById('dice').textContent = `🎲 ${roll}`;
    if (roll === 1) switchTurn();
    else currentScore += roll;
    updateDisplay();
}

function saveScore() {
    scores[activePlayer] += currentScore;
    currentScore = 0;
    if (scores[activePlayer] >= 100) declareWinner();
    else switchTurn();
}

function switchTurn() {
    currentScore = 0;
    activePlayer = 1 - activePlayer;
    updateDisplay();
}

function resetGame() {
    scores = [0, 0];
    currentScore = 0;
    activePlayer = 0;
    enableButtons();
    updateDisplay();
}

function updateDisplay() {
    document.getElementById('turn').textContent = `${getPlayerName(activePlayer)}'s Turn`;
    document.getElementById('player1-score').textContent = `${getPlayerName(0)}: ${scores[0]}`;
    document.getElementById('player2-score').textContent = `${getPlayerName(1)}: ${scores[1]}`;
    document.getElementById('current-score').textContent = `Current Score: ${currentScore}`;
}

function getPlayerName(index) {
    return document.getElementById(`player${index + 1}`).value || `Player ${index + 1}`;
}

function declareWinner() {
    document.getElementById('turn').textContent = `${getPlayerName(activePlayer)} Wins! 🎉`;
    disableButtons();
}

function disableButtons() {
    document.querySelectorAll('button').forEach(btn => btn.disabled = true);
}

function enableButtons() {
    document.querySelectorAll('button').forEach(btn => btn.disabled = false);
}
