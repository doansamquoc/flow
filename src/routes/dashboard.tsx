import Header from "@/components/header";
import { createFileRoute, Outlet } from "@tanstack/react-router";

export const Route = createFileRoute("/dashboard")({
  component: RouteComponent,
});

function RouteComponent() {
  return (
    <div>
      <header><Header/></header>
      <main className='mx-auto max-w-3xl'>
        <Outlet />
      </main>
    </div>
  );
}
