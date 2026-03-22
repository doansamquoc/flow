import { createRootRoute, Outlet } from "@tanstack/react-router";
import { NotFoundPage } from "./not-found";
import Loading from "@/components/loading";

export const Route = createRootRoute({
  component: Outlet,
  pendingComponent: () => <Loading children='Đang tải' />,
  pendingMs: 100,
  notFoundComponent: NotFoundPage,
});
