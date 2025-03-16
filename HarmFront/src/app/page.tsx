import Link from "next/link";

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
    </div>
  );
}
