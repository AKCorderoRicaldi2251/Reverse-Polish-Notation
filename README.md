# Reverse Polish Notation
## Overview

This program evaluates mathematical expressions written in **Reverse Polish Notation (RPN)** using a stack-based approach.

Reverse Polish Notation (also known as postfix notation) places operators after their operands.  

---
The program includes validation, structured error handling, and floating-point rounding correction.

---

## How the Algorithm Works

1. The input expression is split into space-separated tokens.
2. A stack is created to store numeric values.
3. The program processes tokens from left to right:
   - If the token is a number, it is pushed onto the stack.
   - If the token is an operator:
     - The top two values are popped from the stack.
     - The operation is performed.
     - The result is pushed back onto the stack.
4. After all tokens are processed:
   - If exactly one value remains on the stack, it is returned.
   - Otherwise, the expression is considered invalid.

---

## Supported Operators

| Operator | Description        |
|----------|-------------------|
| `+`      | Addition           |
| `-`      | Subtraction        |
| `*`      | Multiplication     |
| `/`      | Division           |
| `^`      | Exponentiation     |

---
### Fields
- None (all methods are instance or static).

### Methods

#### `double evaluateStr(String expression)`
- Evaluates a string expression in RPN.
- Steps:
  1. Splits the expression into space-separated tokens.
  2. Uses a `Stack<Double>` to store operands.
  3. Iterates over each token:
     - If a number, parses it and pushes it onto the stack.
     - If an operator, pops the top two numbers, applies the operation, and pushes the result.
     - Throws `IllegalArgumentException` if a token is invalid or if there are not enough operands.
  4. Returns the result rounded to **9 decimal places**.
- Throws:
  - `IllegalArgumentException` for invalid input or token errors.
  - `ArithmeticException` for division by zero.

#### `boolean isOperator(String s)`
- Returns `true` if the input string is one of: `+`, `-`, `*`, `/`, `^`.
- Used by `evaluateStr` to identify operators.

#### `static boolean isNumber(String s)`
- Returns `true` if the string can be parsed as a `Double`.
- Returns `false` otherwise.
- Used for token validation.

#### `public static void main(String[] args)`
- Entry point for the program.
- Creates an instance of `Main`.
- Demonstrates the evaluator on several test expressions.
- Example calls:
  ```java
  m.evaluateStr("2 3 +");    // 5.0
  m.evaluateStr("0.2 0.1 +"); // 0.3 (rounded)

## Error Handling

The program throws exceptions in the following situations:

### `IllegalArgumentException`
- Expression is null or empty
- Invalid token detected
- Not enough operands for an operator
- Too many operands remaining after evaluation

### `ArithmeticException`
- Division by zero

---

## Floating-Point Precision Handling

Because Java uses IEEE-754 floating-point representation, some decimal calculations (e.g. `0.2 0.1 +`) may produce minor precision errors.

To reduce this issue, results are rounded to **9 decimal places** before being returned.

---
