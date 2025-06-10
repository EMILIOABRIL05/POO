import numpy as np
import matplotlib.pyplot as plt
import sympy as sp
import re
import os
from sympy.parsing.sympy_parser import parse_expr, standard_transformations, implicit_multiplication_application
from sympy import symbols, sin, cos, tan, sec, log, sqrt, sympify, E, pi

def validar_funcion(funcion_texto):
    """
    Valida la sintaxis de la función ingresada y la convierte a formato SymPy.
    """
    try:
        # Reemplazar términos intuitivos por funciones de SymPy
        funcion_texto = funcion_texto.lower()

        # Reemplazar constantes conocidas
        funcion_texto = funcion_texto.replace('pi', 'pi')
        funcion_texto = funcion_texto.replace('e', 'E')

        # Reemplazar funciones con formato intuitivo
        funcion_texto = re.sub(r'seno\s*\(\s*([^)]+)\s*\)', r'sin(\1)', funcion_texto)
        funcion_texto = re.sub(r'coseno\s*\(\s*([^)]+)\s*\)', r'cos(\1)', funcion_texto)
        funcion_texto = re.sub(r'tangente\s*\(\s*([^)]+)\s*\)', r'tan(\1)', funcion_texto)
        funcion_texto = re.sub(r'secante\s*\(\s*([^)]+)\s*\)', r'sec(\1)', funcion_texto)
        funcion_texto = re.sub(r'potencia\s*\(\s*([^,]+)\s*,\s*([^)]+)\s*\)', r'(\1)**(\2)', funcion_texto)
        funcion_texto = re.sub(r'raiz\s*\(\s*([^)]+)\s*\)', r'sqrt(\1)', funcion_texto)
        funcion_texto = re.sub(r'logaritmo_natural\s*\(\s*([^)]+)\s*\)', r'log(\1)', funcion_texto)
        funcion_texto = re.sub(r'logaritmo\s*\(\s*([^,]+)\s*,\s*([^)]+)\s*\)', r'log(\2, \1)', funcion_texto)
        funcion_texto = re.sub(r'cotangente\s*\(\s*([^)]+)\s*\)', r'1/tan(\1)', funcion_texto)
        funcion_texto = re.sub(r'cosecante\s*\(\s*([^)]+)\s*\)', r'1/sin(\1)', funcion_texto)

        # Configurar transformaciones para el parser
        transformations = standard_transformations + (implicit_multiplication_application,)

        # Intentar parsear la expresión con transformaciones mejoradas
        x = symbols('x')
        expr = parse_expr(funcion_texto, transformations=transformations)

        # Verificar que la expresión es válida evaluándola en un punto
        expr.subs(x, 1)

        return True, expr
    except Exception as e:
        # Proporcionar mensajes de error más detallados
        if "parsing" in str(e).lower():
            return False, "Error de sintaxis en la expresión. Verifique paréntesis y operadores."
        elif "invalid" in str(e).lower():
            return False, "Expresión inválida. Verifique que todas las funciones y variables estén correctamente definidas."
        else:
            return False, f"Error: {str(e)}"

def integracion_numerica(expr, a, b, metodo='simpson', puntos=1000):
    """
    Calcula la integral definida numéricamente usando el método especificado.

    Métodos disponibles:
    - 'trapezoidal': Regla del trapecio
    - 'simpson': Regla de Simpson (por defecto)
    """
    try:
        x = symbols('x')
        f = sp.lambdify(x, expr, "numpy")

        # Crear puntos de evaluación
        x_vals = np.linspace(a, b, puntos)

        # Evaluar la función en los puntos
        y_vals = []
        for x_val in x_vals:
            try:
                y_val = float(f(x_val))
                if np.isnan(y_val) or np.isinf(y_val) or isinstance(y_val, complex):
                    return False, "La función no está definida en todo el intervalo de integración."
                y_vals.append(y_val)
            except Exception:
                return False, "Error al evaluar la función en x = " + str(x_val)

        # Calcular la integral usando el método especificado
        if metodo == 'trapezoidal':
            # Regla del trapecio
            h = (b - a) / (puntos - 1)
            resultado = h * (0.5 * y_vals[0] + 0.5 * y_vals[-1] + sum(y_vals[1:-1]))
        elif metodo == 'simpson':
            # Regla de Simpson (requiere un número impar de puntos)
            if puntos % 2 == 0:
                puntos += 1
                x_vals = np.linspace(a, b, puntos)
                y_vals = [float(f(x_val)) for x_val in x_vals]

            h = (b - a) / (puntos - 1)
            resultado = h/3 * (y_vals[0] + y_vals[-1] + 
                              4 * sum(y_vals[1:-1:2]) + 
                              2 * sum(y_vals[2:-1:2]))
        else:
            return False, "Método de integración no reconocido."

        return True, resultado
    except Exception as e:
        return False, f"Error en la integración numérica: {str(e)}"

def calcular_integral(expr, a, b, puntos=1000):
    """
    Calcula la integral definida de la función en el intervalo [a, b]
    usando la integración simbólica de SymPy. Si falla, utiliza métodos numéricos.
    """
    try:
        x = symbols('x')
        # Intentar integración simbólica primero
        try:
            integral = sp.integrate(expr, (x, a, b))
            # Convertir a float si es posible para una representación más limpia
            try:
                integral_valor = float(integral)
                return True, integral_valor
            except:
                return True, integral
        except Exception as e:
            print(f"Integración simbólica fallida: {str(e)}")
            print("Intentando integración numérica...")

            # Si la integración simbólica falla, usar integración numérica
            exito, resultado = integracion_numerica(expr, a, b, 'simpson', puntos)
            if exito:
                return True, resultado
            else:
                # Intentar con el método trapezoidal si Simpson falla
                exito, resultado = integracion_numerica(expr, a, b, 'trapezoidal', puntos)
                if exito:
                    return True, resultado
                else:
                    return False, resultado
    except Exception as e:
        return False, f"Error al calcular la integral: {str(e)}"

def graficar_funcion(expr, a, b, resultado_integral):
    """
    Grafica la función y muestra el área bajo la curva en el intervalo [a, b].
    """
    x = symbols('x')

    # Convertir la expresión simbólica a una función numérica
    f = sp.lambdify(x, expr, "numpy")

    # Generar puntos para la gráfica
    x_vals = np.linspace(a - 0.5, b + 0.5, 1000)
    y_vals = []

    # Evaluar la función en cada punto, manejando posibles errores
    for x_val in x_vals:
        try:
            y_val = f(x_val)
            if isinstance(y_val, complex):
                y_val = np.nan
            elif np.isinf(y_val):
                y_val = np.nan
            y_vals.append(y_val)
        except:
            y_vals.append(np.nan)

    # Crear la gráfica
    plt.figure(figsize=(10, 6))
    plt.plot(x_vals, y_vals, 'b-', label=f'f(x) = {sp.latex(expr)}')

    # Sombrear el área bajo la curva en el intervalo [a, b]
    x_interval = np.linspace(a, b, 200)
    y_interval = []
    for x_val in x_interval:
        try:
            y_val = f(x_val)
            if isinstance(y_val, complex) or np.isinf(y_val):
                y_val = np.nan
            y_interval.append(y_val)
        except:
            y_interval.append(np.nan)

    plt.fill_between(x_interval, y_interval, alpha=0.3, color='green')

    # Configurar la gráfica
    plt.grid(True)
    plt.axhline(y=0, color='k', linestyle='-', alpha=0.3)
    plt.axvline(x=0, color='k', linestyle='-', alpha=0.3)
    plt.title(f'Integral de f(x) en [{a}, {b}] = {resultado_integral}')
    plt.xlabel('x')
    plt.ylabel('f(x)')
    plt.legend()

    # Mostrar la gráfica
    plt.show()

def main():
    print("=== Calculadora de Integrales Definidas ===")
    print("Ingrese funciones usando términos como:")
    print("  - seno(x), coseno(x), tangente(x), secante(x)")
    print("  - potencia(base, exponente), raiz(x)")
    print("  - logaritmo_natural(x), logaritmo(base, x)")
    print("  - Operadores: +, -, *, /, ^")
    print("Ejemplo: potencia(x, 2) + seno(x) - 3*x")

    while True:
        try:
            # Solicitar la función al usuario
            funcion_texto = input("\nIngrese la función a integrar (o 'salir' para terminar): ")
            if funcion_texto.lower() == 'salir':
                break

            # Validar la función
            valida, expr = validar_funcion(funcion_texto)
            if not valida:
                print(f"Error en la función: {expr}")
                continue

            # Solicitar los límites de integración
            a = float(input("Ingrese el límite inferior (a): "))
            b = float(input("Ingrese el límite superior (b): "))

            if a >= b:
                print("Error: El límite inferior debe ser menor que el superior.")
                continue

            # Calcular la integral
            exito, resultado = calcular_integral(expr, a, b)
            if not exito:
                print(f"Error al calcular la integral: {resultado}")
                continue

            # Mostrar el resultado
            print(f"\nLa integral de {expr} en el intervalo [{a}, {b}] es: {resultado}")

            # Graficar la función
            graficar_funcion(expr, a, b, resultado)

        except Exception as e:
            print(f"Error: {str(e)}")

if __name__ == "__main__":
    main()
