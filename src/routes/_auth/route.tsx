import { createFileRoute, Outlet } from "@tanstack/react-router";

export const Route = createFileRoute("/_auth")({
  component: AuthGuard,
});

function AuthGuard() {
  return <Outlet />;
}
