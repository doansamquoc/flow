import { createFileRoute, Outlet } from "@tanstack/react-router";

export const Route = createFileRoute("/_guest")({
  component: GuestGuard,
});

function GuestGuard() {
  return <Outlet />;
}
