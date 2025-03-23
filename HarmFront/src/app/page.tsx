import Link from "next/link";
import MessageComponent from "./components/MessageComponent";

export default function Home() {
  return (
    <div className="flex flex-col items-center justify-center min-h-screen">
      <h1 className="text-3xl font-bold">Witaj w aplikacji!</h1>
      <p className="mt-4">Kliknij poniżej, aby się zalogować:</p>
      <Link href="/login">
        <button className="mt-4 p-2 bg-blue-500 text-white rounded">
          Przejdź do logowania
        </button>
      </Link>
      <div className="mt-8 p-6 bg-white shadow-lg rounded-lg w-1/2 mx-auto text-center">
        <h1 className="text-2xl font-bold text-gray-800 mb-4">Napis z bazy przekazany przez backend:</h1>
        <div className="p-4 bg-gray-800 rounded-md">
          <MessageComponent />
        </div>
      </div>

    </div>
  );
}
