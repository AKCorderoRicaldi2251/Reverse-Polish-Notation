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
