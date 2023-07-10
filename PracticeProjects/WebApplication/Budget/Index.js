import React from "react";
import ReactDOM from "react-dom";
import App from "./App";

document.getElementById('calculateTotalBtn').addEventListener('click', function() {
    const expensePrices = document.querySelectorAll('input[type="number"]');
    let totalExpense = 0;

    for (let i = 0; i < expensePrices.length; i++) {
        const expensePrice = parseFloat(expensePrices[i].value) || 0;
        totalExpense += expensePrice;
    }

    const roundedTotal = Math.round(totalExpense);
    document.getElementById('totalExpense').textContent = roundedTotal;
});

function createExpenseFields() {
    var numExpenses = parseInt(document.getElementById("numExpenses").value);
    var expenseFieldsDiv = document.getElementById("expenseFields");
    expenseFieldsDiv.innerHTML = "";

    for (var i = 0; i < numExpenses; i++) {
        var expenseField = document.createElement("input");
        expenseField.type = "number";
        expenseField.placeholder = "Expense " + (i + 1);
        expenseFieldsDiv.appendChild(expenseField);
    }
}

function calculateTotalExpense() {
    var expenseFields = document.getElementById("expenseFields").querySelectorAll("input");
    var totalExpense = 0;

    for (var i = 0; i < expenseFields.length; i++) {
        var expenseValue = parseInt(expenseFields[i].value);
        if (!isNaN(expenseValue)) {
            totalExpense += expenseValue;
        }
    }

    document.getElementById("totalExpense").innerHTML = "Total Expense: " + totalExpense;
}

ReactDOM.render(<App />, document.getElementById('root'));