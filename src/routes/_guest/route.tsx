import Loading from "@/components/loading";
import { magic } from "@/lib/magic";
import { createFileRoute, Outlet, redirect } from "@tanstack/react-router";

export const Route = createFileRoute("/_guest")({
  beforeLoad: async () => {
    const isAuthenticated = await magic.user.isLoggedIn();
    if (isAuthenticated) {
      throw redirect({ to: "/dashboard" });
    }
  },
  pendingComponent: () => <Loading children={"Đang tải"} />,
  component: Outlet,
});
