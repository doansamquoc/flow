import Header from "@/components/header";
import Loading from "@/components/loading";
import { magic } from "@/lib/magic";
import { createFileRoute, Outlet, redirect } from "@tanstack/react-router";

export const Route = createFileRoute("/_auth")({
  beforeLoad: async () => {
    const isAuthenticated = await magic.user.isLoggedIn();
    if (!isAuthenticated) {
      throw redirect({ to: "/login" });
    }
  },
  pendingComponent: () => <Loading children={"Đang tải"} />,
  component: Dashboard,
});

function Dashboard() {
  return (
    <div>
      <header>
        <Header />
      </header>
      <main className='max-w-4xl mx-auto p-2'>
        <Outlet />
      </main>
    </div>
  );
}
