import { useEffect, useState } from "react";
import { getTasks } from "./api";

function App() {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    getTasks()
      .then((data) => setTasks(data))
      .catch((error) => console.error("Błąd API:", error));
  }, []);

  return (
    <div>
      <h1>Napis z bazy:</h1>
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            <strong>{task.title}</strong>: {task.description}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default App;
