import { createFileRoute } from "@tanstack/react-router";

export const Route = createFileRoute("/not-found")({
  component: NotFoundPage,
});

export function NotFoundPage() {
  return <div>Hello "/not-found"!</div>;
}
