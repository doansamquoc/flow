import { Button } from "@/components/ui/button";
import type { Provider } from "../types/provider.type";
import { Spinner } from "@/components/ui/spinner";
import { providerConfig } from "../configs/provider.config";

interface OAuthButtonProps {
  provider: Provider;
}

const OAuthButton = ({ provider }: OAuthButtonProps) => {};

export default OAuthButton;
