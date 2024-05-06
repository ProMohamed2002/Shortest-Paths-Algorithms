import random

def generate_graph_file(filename, num_nodes, num_edges):
    with open(filename, 'w') as file:
        file.write(f"{num_nodes}\n")
        file.write(f"{num_edges}\n")
        for _ in range(num_edges):
            from_node = random.randint(0, num_nodes - 1)
            to_node = random.randint(0, num_nodes - 1)
            weight = random.randint(1, 100)
            file.write(f"{from_node} {to_node} {weight}\n")

for i in range(1, 21):
    num_nodes = 50 * i  # Increase nodes by 20 at each iteration
    num_edges = num_nodes - 10  # Calculate number of edges
    filename = f"graph{i}.txt"  # Generate filename based on iteration
    generate_graph_file(filename, num_nodes, num_edges)
    print(f"File '{filename}' generated with {num_nodes} nodes and {num_edges} edges.")
