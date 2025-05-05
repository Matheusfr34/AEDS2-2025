import random
import time
import matplotlib.pyplot as plt

# Selection Sort
def selection_sort(arr):
    comparisons = 0
    movements = 0
    n = len(arr)
    
    for i in range(n):
        min_idx = i
        for j in range(i+1, n):
            comparisons += 1
            if arr[j] < arr[min_idx]:
                min_idx = j
        
        if min_idx != i:
            arr[i], arr[min_idx] = arr[min_idx], arr[i]
            movements += 1
    
    return comparisons, movements

# Insertion Sort
def insertion_sort(arr):
    comparisons = 0
    movements = 0
    n = len(arr)
    
    for i in range(1, n):
        key = arr[i]
        j = i-1
        
        while j >= 0:
            comparisons += 1
            if arr[j] > key:
                arr[j+1] = arr[j]
                movements += 1
                j -= 1
            else:
                break
        
        arr[j+1] = key
        movements += 1
    
    return comparisons, movements

# Bubble Sort
def bubble_sort(arr):
    comparisons = 0
    movements = 0
    n = len(arr)
    
    for i in range(n):
        swapped = False
        for j in range(0, n-i-1):
            comparisons += 1
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]
                movements += 1
                swapped = True
        
        if not swapped:
            break
    
    return comparisons, movements

# Quick Sort
def quick_sort(arr):
    def partition(low, high):
        nonlocal comparisons, movements
        pivot = arr[high]
        i = low - 1
        
        for j in range(low, high):
            comparisons += 1
            if arr[j] <= pivot:
                i += 1
                if i != j:
                    arr[i], arr[j] = arr[j], arr[i]
                    movements += 1
        
        if i+1 != high:
            arr[i+1], arr[high] = arr[high], arr[i+1]
            movements += 1
        return i + 1
    
    def quick_sort_recursive(low, high):
        nonlocal comparisons
        comparisons += 1
        if low < high:
            pi = partition(low, high)
            quick_sort_recursive(low, pi-1)
            quick_sort_recursive(pi+1, high)
    
    comparisons = 0
    movements = 0
    quick_sort_recursive(0, len(arr)-1)
    return comparisons, movements

# Função para testar os algoritmos
def test_sorting_algorithms():
    sizes = [100, 1000, 10000, 100000]
    algorithms = {
        'Selection Sort': selection_sort,
        'Insertion Sort': insertion_sort,
        'Bubble Sort': bubble_sort,
        'QuickSort': quick_sort
    }
    
    results = {alg: {'time': [], 'comparisons': [], 'movements': []} for alg in algorithms}
    
    for size in sizes:
        arr = [random.randint(0, size) for _ in range(size)]
        
        for alg_name, alg_func in algorithms.items():
            # Fazemos uma cópia para não alterar o array original
            arr_copy = arr.copy()
            
            start_time = time.time()
            comparisons, movements = alg_func(arr_copy)
            end_time = time.time()
            
            elapsed_time = (end_time - start_time) * 1000  # em milissegundos
            
            results[alg_name]['time'].append(elapsed_time)
            results[alg_name]['comparisons'].append(comparisons)
            results[alg_name]['movements'].append(movements)
            
            print(f"{alg_name} - Size {size}: Time = {elapsed_time:.2f}ms, Comparisons = {comparisons}, Movements = {movements}")
    
    return results

# Gerar gráficos
def plot_results(results, sizes):
    algorithms = list(results.keys())
    
    # Tempo de execução
    plt.figure(figsize=(10, 6))
    for alg in algorithms:
        plt.plot(sizes, results[alg]['time'], marker='o', label=alg)
    plt.xscale('log')
    plt.yscale('log')
    plt.xlabel('Tamanho do vetor (log)')
    plt.ylabel('Tempo de execução (ms, log)')
    plt.title('Tempo de execução por algoritmo')
    plt.legend()
    plt.grid()
    plt.savefig('execution_time.png')
    plt.close()
    
    # Número de comparações
    plt.figure(figsize=(10, 6))
    for alg in algorithms:
        plt.plot(sizes, results[alg]['comparisons'], marker='o', label=alg)
    plt.xscale('log')
    plt.yscale('log')
    plt.xlabel('Tamanho do vetor (log)')
    plt.ylabel('Número de comparações (log)')
    plt.title('Número de comparações por algoritmo')
    plt.legend()
    plt.grid()
    plt.savefig('comparisons.png')
    plt.close()
    
    # Número de movimentações
    plt.figure(figsize=(10, 6))
    for alg in algorithms:
        plt.plot(sizes, results[alg]['movements'], marker='o', label=alg)
    plt.xscale('log')
    plt.yscale('log')
    plt.xlabel('Tamanho do vetor (log)')
    plt.ylabel('Número de movimentações (log)')
    plt.title('Número de movimentações por algoritmo')
    plt.legend()
    plt.grid()
    plt.savefig('movements.png')
    plt.close()

# Executar testes e gerar gráficos
sizes = [100, 1000, 10000, 100000]
results = test_sorting_algorithms()
plot_results(results, sizes)